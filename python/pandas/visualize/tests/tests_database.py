import database

df = database.get_data_base_from_csv_file("../database")


def test_filter_data_until_sprint():
    result = database.filter_issues_until_sprint(df, 80)
    print(result)
    result = database.filter_issues_until_sprint(df, 79)
    print(result)


def test_calculate_issues_status_percent():
    # result = database.calculate_issues_status_percent(df, "assignee")
    # print(result.to_markdown())

    # result = database.calculate_issues_status_percent(df, "sprint")
    # print(result.to_markdown())

    # result = database.calculate_issues_status_percent(df, "team")
    # print(result.to_markdown())

    result = database.issues_aggregation_by_column(df, "area")
    print(result.to_markdown())


def test_calculate_issues_status_count():
    result = database.issues_aggregation_by_sprint(df, "assignee")
    print(result.to_markdown())

    result = database.issues_aggregation_by_sprint(df, "team")
    print(result.to_markdown())

    result = database.issues_aggregation_by_sprint(df, "area")
    print(result.to_markdown())