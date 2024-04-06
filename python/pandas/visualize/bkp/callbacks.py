@callback(
    Output(component_id='bar_chart_by_email_and_sprint_cumulative', component_property='figure'),
    Input(component_id='input_slider_individual_sprint', component_property='value')
)
def bar_chart_by_email_and_sprint_cumulative(sprint: int):
    df = engine.filter_data_until_sprint(df_individual, sprint)
    df = engine.calculate_mean_closed_percent_by_email(df)

    fig = px.bar(
        df,
        orientation="h",
        text_auto=True
    )

    fig.update_layout(xaxis={"dtick": 10}, margin={"t": 100, "b": 100}, height=900, barmode="stack")
    fig.update_traces(textposition="outside")

    return fig


@callback(
    Output(component_id='bar_chart_by_email_and_sprint', component_property='figure'),
    [
        Input(component_id='email', component_property='value'),
        Input(component_id='input_slider_individual_sprint', component_property='value'),
    ]
)
def bar_chart_by_email_and_sprint(email: str, sprint: int):
    df = engine.filter_data_until_sprint(df_individual, sprint)
    df = engine.filter_email(df, email)

    fig = px.bar(
        df,
        orientation="v",
        x="sprint",
        y="issues_total_closed_percent",
        text="issues_total_closed_percent"
    )

    fig.update_layout(xaxis={"dtick": 1}, margin={"t": 100, "b": 100}, height=900, barmode="stack")
    fig.update_traces(textposition="outside")

    return fig
