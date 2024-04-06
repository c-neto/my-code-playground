import pandas as pd


def enrich_column_issues_unplanned_percent(df: pd.DataFrame) -> None:
    unplanned_filter = df["issues_unplanned"] / df["issues_total"]
    df["issues_unplanned_percent"] = (unplanned_filter * 100).round()


def enrich_column_total_issues_closed_percent(df: pd.DataFrame) -> None:
    closed_filter = df["issues_total_closed"] / df["issues_total"]
    df["issues_total_closed_percent"] = (closed_filter * 100).round()


def filter_issues_by_sprint(data_frame: pd.DataFrame, sprint: int) -> pd.DataFrame:
    sprint_filter = data_frame["sprint"] == sprint
    filtered_df = data_frame[sprint_filter]
    return filtered_df


def filter_data_until_sprint(data_frame: pd.DataFrame, sprint: int) -> pd.DataFrame:
    sprint_filter = data_frame["sprint"] <= sprint
    filtered_df = data_frame[sprint_filter]
    return filtered_df


def filter_email(data_frame: pd.DataFrame, email: str) -> pd.DataFrame:
    sprint_filter = data_frame["assignee"] == email
    filtered_df = data_frame[sprint_filter]
    return filtered_df


def filter_team(data_frame: pd.DataFrame, team: str) -> pd.DataFrame:
    sprint_filter = data_frame["team"] == team
    filtered_df = data_frame[sprint_filter]
    return filtered_df


def calculate_mean_closed_percent_by_email(data_frame: pd.DataFrame) -> pd.Series:
    mean_closed_percent_by_email = data_frame.groupby("assignee")["issues_total_closed_percent"].mean().round().dropna().sort_values()
    return mean_closed_percent_by_email


def calculate_mean_closed_percent_by_sprint(data_frame: pd.DataFrame) -> pd.Series:
    mean_closed_percent_by_sprint = data_frame.groupby("sprint")["issues_total_closed_percent"].mean().sort_values(ascending=False)
    mean_closed_percent_by_sprint = mean_closed_percent_by_sprint.round()
    return mean_closed_percent_by_sprint


def calculate_mean_unplanned_percent_by_sprint(data_frame: pd.DataFrame) -> pd.Series:
    mean_unplanned_percent_by_sprint = data_frame.groupby("sprint")["issues_unplanned_percent"].mean().dropna()
    return mean_unplanned_percent_by_sprint


def calculate_mean_closed_percent_by_team(data_frame: pd.DataFrame) -> pd.Series:
    team_sprint_fields = ["team", "sprint"]
    mean_closed_percent_by_team = data_frame.groupby(team_sprint_fields)["issues_total_closed_percent"].mean().dropna()
    return mean_closed_percent_by_team


def extract_issues_data_by_sprint(data_frame: pd.DataFrame, sprint: int) -> pd.DataFrame:
    sprint_filter = data_frame["sprint"] == sprint
    issues_data_fields = ["assignee", "issues_total", "issues_total_closed"]
    extracted_data = data_frame[sprint_filter][issues_data_fields]
    return extracted_data


def extract_planned_issues_data_by_sprint(data_frame: pd.DataFrame, sprint: int) -> pd.DataFrame:
    sprint_filter = data_frame["sprint"] == sprint
    planned_data_fields = ["assignee", "issues_total", "issues_total_closed"]
    planned_data = data_frame[sprint_filter][planned_data_fields]
    return planned_data


def extract_time_data_by_sprint(data_frame: pd.DataFrame, sprint: int) -> pd.DataFrame:
    sprint_filter = data_frame["sprint"] == sprint
    time_data_fields = ["assignee", "time_original_estimate", "time_spent"]
    time_data = data_frame[sprint_filter][time_data_fields]
    return time_data


def calculate_issues_performance_by_sprint(data_frame: pd.DataFrame, sprint: int) -> pd.DataFrame:
    sprint_filter = data_frame["sprint"] == sprint
    closed_issues_fields = ["issues_total", "issues_total_closed", "issues_epic_closed"]
    performance_metrics = data_frame[sprint_filter].groupby("team")[closed_issues_fields].sum()
    return performance_metrics


def calculate_mean_closed_percent_by_team_and_sprint(data_frame: pd.DataFrame, sprint: int) -> pd.Series:
    sprint_filter = data_frame["sprint"] == sprint
    mean_closed_percent_by_team = data_frame[sprint_filter].groupby("team")["issues_total_closed_percent"]
    return mean_closed_percent_by_team


def calculate_issues_status_by_sprint(data_frame: pd.DataFrame) -> pd.DataFrame:
    status_fields = ["issues_status_to_do", "issues_status_in_progress", "issues_total_closed"]
    status_metrics_by_sprint = data_frame.groupby("sprint")[status_fields].sum()
    return status_metrics_by_sprint


def calculate_issues_status_by_epic_name(data_frame: pd.DataFrame) -> pd.DataFrame:
    status_fields = ["issues_status_to_do", "issues_status_in_progress", "issues_total_closed"]
    status_metrics_by_sprint = data_frame.groupby("epic_name")[status_fields].sum()
    return status_metrics_by_sprint


def get_first_and_last_sprint(data_frame: pd.DataFrame) -> (int, int):
    first_sprint = data_frame["sprint"].unique().min()
    last_sprint = data_frame["sprint"].unique().max()

    return first_sprint, last_sprint


def get_individual_names(data_frame: pd.DataFrame) -> pd.Series:
    emails = data_frame["assignee"].unique()
    return emails


def get_individual_teams(data_frame: pd.DataFrame) -> pd.Series:
    emails = data_frame["team"].unique()
    return emails
