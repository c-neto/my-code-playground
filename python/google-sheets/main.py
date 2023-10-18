import os.path

from google.auth.transport.requests import Request
from google.oauth2.credentials import Credentials
from google_auth_oauthlib.flow import InstalledAppFlow
from googleapiclient.discovery import build
from googleapiclient.errors import HttpError

# If modifying these scopes, delete the file token.json.
SCOPES = ['https://www.googleapis.com/auth/spreadsheets']

# The ID and range of a sample spreadsheet.
SAMPLE_SPREADSHEET_ID = ''
SAMPLE_RANGE_NAME = 'page1!A:Z'


def main():
    """Shows basic usage of the Sheets API.
    Prints values from a sample spreadsheet.
    """
    creds = None
    # The file token.json stores the user's access and refresh tokens, and is
    # created automatically when the authorization flow completes for the first
    # time.
    if os.path.exists('token.json'):
        creds = Credentials.from_authorized_user_file('token.json', SCOPES)
    # If there are no (valid) credentials available, let the user log in.
    if not creds or not creds.valid:
        if creds and creds.expired and creds.refresh_token:
            creds.refresh(Request())
        else:
            flow = InstalledAppFlow.from_client_secrets_file(
                'client-secret.json', SCOPES)
            creds = flow.run_local_server(port=0)
        # Save the credentials for the next run
        with open('token.json', 'w') as token:
            token.write(creds.to_json())

    service = build('sheets', 'v4', credentials=creds)

    # Call the Sheets API
    # sheet = service.spreadsheets()
    # result = sheet.values().get(
    #     spreadsheetId=SAMPLE_SPREADSHEET_ID,
    #     range=SAMPLE_RANGE_NAME
    # ).execute()
    # values = result.get('values', [])
    # print(values)

    rows = service.spreadsheets().values().get(spreadsheetId=SAMPLE_SPREADSHEET_ID, range=SAMPLE_RANGE_NAME).execute().get('values', [])
    last_row = rows[-1] if rows else None
    last_row_id = len(rows)
    print(last_row_id, last_row)

    data = [["valuea1"], ["carlos", "xsaxsa"], ["value3"]]
    resource = {
        "majorDimension": "ROWS",
        "values": data
    }

    service.spreadsheets().values().append(
      spreadsheetId=SAMPLE_SPREADSHEET_ID,
      range="page1!A:A",
      body=resource,
      valueInputOption="USER_ENTERED"
    ).execute()


if __name__ == '__main__':
    main()
