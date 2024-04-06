import dash
import dash_bootstrap_components as dbc
from dash import dcc
from dash import html, callback, Input, Output
import plotly.express as px
import database as db
from settings import settings
import plotly.graph_objects as go


dash.register_page(__name__)


global_data_frame = db.get_data_base_from_csv_file(settings["reports_directory"])


input_team = dcc.Dropdown(
    options=db.get_unique_teams(global_data_frame),
    value=db.get_unique_teams(global_data_frame)[0],
    id='input_team'
)
input_assignee = dcc.Dropdown(
    options=db.get_unique_assignees(global_data_frame),
    value=db.get_unique_assignees(global_data_frame)[0],
    id='input_assignee'
)


layout = dbc.Container(
    [
        dbc.Row(
            [
                dbc.Col([dbc.Label("Team"), input_team]),
            ]
        ),
        html.Hr(),
        dbc.Row(
            [
                dbc.Col(dcc.Graph(figure={}, id="bar_chart_by_assignee_and_sprint_cumulative"))
            ]
        ),
        html.Hr(),
        dbc.Row(
            [
                dbc.Col([dbc.Label("Email"), input_assignee])
            ]
        ),
        dbc.Row(
            [
                dbc.Col(dcc.Graph(figure={}, id="bar_chart_by_assignee_and_sprint"))
            ]
        ),
    ]
)


@callback(
    Output(component_id='bar_chart_by_assignee_and_sprint_cumulative', component_property='figure'),
    [
        Input(component_id='input_team', component_property='value'),
    ]
)
def bar_chart_by_assignee_and_sprint_cumulative(team: str):
    df = global_data_frame.copy(deep=True)

    if team:
        df = db.filter_issues_by_team(df, team)

    df = db.issues_aggregation_by_column(df, "assignee")

    fig = px.bar(
        df,
        orientation="h",
        text_auto=True,
        color="issue_done_percent",
        x="issue_done_percent", y="assignee",
        range_color=[0, 100],
        color_continuous_scale=[(0, "red"), (0.5, "yellow"), (1, "green")],
        title=f"General Sprint Performance by Team Members - {team if team else 'All teams members'}"
    )

    fig.update_layout(xaxis={"dtick": 10}, margin={"t": 100, "b": 100}, height=700, barmode="stack", showlegend=False)
    fig.update_traces(textposition="outside")

    return fig


@callback(
    Output(component_id='bar_chart_by_assignee_and_sprint', component_property='figure'),
    [
        Input(component_id='input_assignee', component_property='value')
    ]
)
def bar_chart_by_assignee_and_sprint(assignee: str):
    df = global_data_frame.copy(deep=True)
    df = db.filter_issues_by_assignee(df, assignee)
    df = db.issues_aggregation_by_sprint(df, "assignee")

    fig = px.line(
        df,
        orientation="v",
        # text_auto=True,
        # color="issue_done_percent",
        x="sprint",
        y=["issue_done_percent", "issue_planned_percent"],
        # range_color=[0, 100],
        # color_continuous_scale=[(0, "red"), (0.5, "yellow"), (1, "green")],
        title=f"XXX"
    )

    print(df.to_markdown())

    fig.update_layout(xaxis={"dtick": 10}, margin={"t": 100, "b": 100}, height=700, barmode="group", showlegend=True, yaxis_range=[0, 100])
    # fig.update_traces(textposition="outside")

    return fig

