import pandas as pd
from bkp import engine

df = pd.read_csv("../database/epic.csv")
engine.enrich_column_total_issues_closed_percent(df)


def test_filter_data_until_sprint():
    result = engine.filter_data_until_sprint(df, 74)
    print(result)


def test_all_issues_performance_mean_by_team_and_sprint():
    result = engine.calculate_issues_status_by_sprint(df)
    print(result)

