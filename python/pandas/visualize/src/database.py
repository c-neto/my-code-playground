from pathlib import Path
import pandas as pd
import numpy as np


def get_data_base_from_csv_file(reports_directory: str) -> pd.DataFrame:
    reports_path = Path(reports_directory)
    df_from_each_file = (
        pd.read_csv(report_file)
        for report_file in reports_path.glob("*.csv")
    )
    concatenated_df = pd.concat(df_from_each_file, ignore_index=True)
    return concatenated_df


def get_unique_assignees(data_frame: pd.DataFrame) -> pd.Series:
    assignees = data_frame["assignee"].unique()
    return assignees


def get_unique_teams(data_frame: pd.DataFrame) -> pd.Series:
    assignees = data_frame["team"].unique()
    return assignees


def filter_issues_by_sprint(data_frame: pd.DataFrame, sprint: int) -> pd.DataFrame:
    filter_sprint = data_frame["sprint"] == sprint
    filtered_df = data_frame[filter_sprint]
    return filtered_df


def filter_issues_by_assignee(data_frame: pd.DataFrame, assignee: str) -> pd.DataFrame:
    filter_assignee = data_frame["assignee"] == assignee
    filtered_df = data_frame[filter_assignee]
    return filtered_df


def filter_issues_by_team(data_frame: pd.DataFrame, team: str) -> pd.DataFrame:
    filter_team = data_frame["team"] == team
    filtered_df = data_frame[filter_team]
    return filtered_df


def filter_issues_by_year(data_frame: pd.DataFrame, year: int) -> pd.DataFrame:
    sprint_filter = data_frame["year"] == year
    filtered_df = data_frame[sprint_filter]
    return filtered_df


def filter_issues_until_sprint(data_frame: pd.DataFrame, sprint: int) -> pd.DataFrame:
    sprint_filter = data_frame["sprint"] <= sprint
    filtered_df = data_frame[sprint_filter]
    return filtered_df


def issues_aggregation_by_column(data_frame: pd.DataFrame, column='assignee'):
    new_df = pd.DataFrame()
    new_df[column] = data_frame[column].unique()

    for cell_value in new_df[column]:
        filter_input_column = (data_frame[column] == cell_value)

        filter_todo = (data_frame["board"] == "todo")
        filter_doing = (data_frame["board"] == "doing")
        filter_done = (data_frame["board"] == "done")

        filter_planned = (data_frame["is_planned"] == True)
        filter_unplanned = (data_frame["is_planned"] == False)

        todo = data_frame[filter_input_column & filter_todo]
        doing = data_frame[filter_input_column & filter_doing]
        done = data_frame[filter_input_column & filter_done]

        planned = data_frame[filter_input_column & filter_planned]
        unplanned = data_frame[filter_input_column & filter_unplanned]

        planned_done = data_frame[filter_input_column & filter_planned & filter_done]
        unplanned_done = data_frame[filter_input_column & filter_unplanned & filter_done]

        todo_count = len(todo)
        doing_count = len(doing)
        done_count = len(done)

        planned_count = len(planned)
        unplanned_count = len(unplanned)

        planned_done_count = len(planned_done)
        unplanned_done_count = len(unplanned_done)

        total_count = todo_count + doing_count + done_count

        row = pd.DataFrame({
            column: [cell_value],
            "issue_total_count": [total_count],
            "issue_todo_count": [todo_count],
            "issue_doing_count": [doing_count],
            "issue_done_count": [done_count],
            "issue_planned_count": [planned_count],
            "issue_unplanned_count": [unplanned_count],
            "issue_planned_done_count": [planned_done_count],
            "issue_unplanned_done_count": [unplanned_done_count],
            "issue_planned_total_count": [planned_count],
            "issue_unplanned_total_count": [unplanned_count]
        })

        new_df = pd.concat([new_df, row])

    new_df["issue_todo_percent"] = (new_df["issue_todo_count"] / new_df["issue_total_count"]) * 100
    new_df["issue_doing_percent"] = (new_df["issue_doing_count"] / new_df["issue_total_count"]) * 100
    new_df["issue_done_percent"] = (new_df["issue_done_count"] / new_df["issue_total_count"]) * 100

    new_df["issue_planned_percent"] = (new_df["issue_planned_done_count"] / new_df["issue_planned_total_count"]) * 100
    new_df["issue_unplanned_percent"] = (new_df["issue_unplanned_done_count"] / new_df[
        "issue_unplanned_total_count"]) * 100

    new_df = new_df.sort_values(by="issue_done_percent")

    return new_df


def issues_aggregation_by_sprint(data_frame: pd.DataFrame, column='assignee'):
    new_df = pd.DataFrame()

    for sprint in data_frame["sprint"].unique():
        for assignee in data_frame[column].unique():
            filter_input_column = (data_frame[column] == assignee) & (data_frame["sprint"] == sprint)

            filter_todo = (data_frame["board"] == "todo")
            filter_doing = (data_frame["board"] == "doing")
            filter_done = (data_frame["board"] == "done")

            filter_planned = (data_frame["is_planned"] == True)
            filter_unplanned = (data_frame["is_planned"] == False)

            todo = data_frame[filter_input_column & filter_todo]
            doing = data_frame[filter_input_column & filter_doing]
            done = data_frame[filter_input_column & filter_done]

            planned = data_frame[filter_input_column & filter_planned]
            unplanned = data_frame[filter_input_column & filter_unplanned]

            planned_done = data_frame[filter_input_column & filter_planned & filter_done]
            unplanned_done = data_frame[filter_input_column & filter_unplanned & filter_done]

            todo_count = len(todo)
            doing_count = len(doing)
            done_count = len(done)

            planned_count = len(planned)
            unplanned_count = len(unplanned)

            planned_done_count = len(planned_done)
            unplanned_done_count = len(unplanned_done)

            total_count = todo_count + doing_count + done_count

            row = pd.DataFrame({
                column: [assignee],
                "sprint": [sprint],
                "issue_total_count": [total_count],
                "issue_todo_count": [todo_count],
                "issue_doing_count": [doing_count],
                "issue_done_count": [done_count],
                "issue_planned_count": [planned_count],
                "issue_unplanned_count": [unplanned_count],
                "issue_planned_done_count": [planned_done_count],
                "issue_unplanned_done_count": [unplanned_done_count],
                "issue_planned_total_count": [planned_count],
                "issue_unplanned_total_count": [unplanned_count]
            })

            new_df = pd.concat([new_df, row])

    new_df["issue_todo_percent"] = (new_df["issue_todo_count"] / new_df["issue_total_count"]) * 100
    new_df["issue_doing_percent"] = (new_df["issue_doing_count"] / new_df["issue_total_count"]) * 100
    new_df["issue_done_percent"] = (new_df["issue_done_count"] / new_df["issue_total_count"]) * 100

    new_df["issue_planned_percent"] = (new_df["issue_planned_done_count"] / new_df["issue_planned_total_count"]) * 100
    new_df["issue_unplanned_percent"] = (new_df["issue_unplanned_done_count"] / new_df["issue_unplanned_total_count"]) * 100

    new_df = new_df.sort_values(["sprint", column, "issue_done_percent"])

    return new_df
