from sprintreports import processor
from pathlib import Path
import json

test_content = Path("./test.json").read_text()
test_json = json.loads(test_content)


def test():
    for issue in test_json["unplanned_issues"]:
        issue = processor.make_issue_row(issue, False, 80)
        print(issue.json())

    for issue in test_json["planned_issues"]:
        issue = processor.make_issue_row(issue, True, 80)
        print(issue.json())
