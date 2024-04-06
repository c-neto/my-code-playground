import pandas as pd
from dash import Dash, html, dcc
import dash_bootstrap_components as dbc
from dash_bootstrap_templates import load_figure_template

from bkp import engine

df_individual = pd.read_csv("database/individual.csv")
engine.enrich_column_total_issues_closed_percent(df_individual)
engine.enrich_column_issues_unplanned_percent(df_individual)

df_area = pd.read_csv("database/area.csv")
df_epic = pd.read_csv("database/epic.csv")


app = Dash(__name__, external_stylesheets=[dbc.themes.MATERIA])
load_figure_template('MATERIA')

first_sprint, last_sprint = engine.get_first_and_last_sprint(df_individual)
input_slider_individual_sprint = dcc.Slider(
    min=first_sprint,
    max=last_sprint,
    step=1,
    value=last_sprint,
    id='input_slider_individual_sprint'
)

emails = engine.get_individual_names(df_individual)
input_email = dcc.Dropdown(
    options=emails,
    value="carlos.neto@trustly.com",
    id='email'
)

teams = engine.get_individual_teams(df_individual)
input_team = dcc.Dropdown(
    options=teams,
    value="carlos.neto@trustly.com",
    id='team'
)


app.layout = html.Div(
    [
        input_slider_individual_sprint,
        dcc.Graph(figure={}, id="bar_chart_by_email_and_sprint_cumulative"),
        html.Hr(),

        input_email,
        dcc.Graph(figure={}, id="bar_chart_by_email_and_sprint"),
        html.Hr()
    ]
)


if __name__ == '__main__':
    app.run(debug=True)
