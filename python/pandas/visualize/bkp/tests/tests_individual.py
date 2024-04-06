import pandas as pd
from bkp import engine

df = pd.read_csv("../database/individual.csv")
engine.enrich_column_total_issues_closed_percent(df)
engine.enrich_column_issues_unplanned_percent(df)


def test_filter_data_until_sprint():
    result = engine.filter_data_until_sprint(df, 74)
    print(result)


def test_all_issues_performance_mean_by_email():
    result = engine.calculate_mean_closed_percent_by_email(df)
    print(result)


def test_calculate_mean_closed_percent_by_sprint():
    result = engine.calculate_mean_closed_percent_by_sprint(df)
    print(result)


def test_calculate_mean_unplanned_percent_by_sprint():
    result = engine.calculate_mean_unplanned_percent_by_sprint(df)
    print(result)


def test_calculate_mean_closed_percent_by_team():
    result = engine.calculate_mean_closed_percent_by_team(df)
    print(result)


def test_calculate_issues_performance_by_sprint():
    result = engine.calculate_issues_performance_by_sprint(df, 78)
    print(result)


def test_planned_issues_and_closed_planned_issues_and_email_by_sprint():
    result = engine.extract_planned_issues_data_by_sprint(df, 78)
    print(result)


def test_original_and_spent_and_email_by_sprint():
    result = engine.extract_time_data_by_sprint(df, 78)
    print(result)


def test_all_issues_performance_mean_by_team_and_sprint():
    result = engine.calculate_issues_status_by_sprint(df)
    print(result)
