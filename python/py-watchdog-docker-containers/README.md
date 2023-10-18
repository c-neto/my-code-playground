# py-watchdog-docker-containers

Check containers running:

```shell
$ docker ps
CONTAINER ID        IMAGE                                      COMMAND                  CREATED             STATUS                          PORTS                    NAMES
25984308e58a        py-watchdog-docker-containers_webservice   "/bin/sh -c 'python3…"   5 minutes ago       Up About a minute (unhealthy)   0.0.0.0:5000->5000/tcp   webservice
```

Run watchdog:

```shell
$ py-watchdog -r 
2020-03-21 14:38:06.668 | INFO     |  Container: webservice - State: unhealthy
2020-03-21 14:38:06.669 | WARNING  |  Restart - webservice
2020-03-21 14:38:18.354 | SUCCESS  |  Container restart with successful - webservice
```

# Docker CLI get histories Healthcheck

To get history:

```shell
docker inspect --format='{{json .State.Health}}' webservice
```

When state of container `healthcheck` is not satisfied, will print follow message:

```json
{
    "Status": "unhealthy",
    "FailingStreak": 20,
    "Log": [
        {
            "Start": "2020-03-20T15:22:06.867631532-03:00",
            "End": "2020-03-20T15:22:07.142541075-03:00",
            "ExitCode": 1,
            "Output": "  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current\n                                 Dload  Upload   Total   Spent    Left  Speed\n\r  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0\r  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0\ncurl: (22) The requested URL returned error: 404 NOT FOUND\n"
        },
        {
            "Start": "2020-03-20T15:22:37.144930921-03:00",
            "End": "2020-03-20T15:22:37.501556858-03:00",
            "ExitCode": 1,
            "Output": "  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current\n                                 Dload  Upload   Total   Spent    Left  Speed\n\r  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0\r  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0\ncurl: (22) The requested URL returned error: 404 NOT FOUND\n"
        },
        {
            "Start": "2020-03-20T15:23:07.505102124-03:00",
            "End": "2020-03-20T15:23:07.809480569-03:00",
            "ExitCode": 1,
            "Output": "  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current\n                                 Dload  Upload   Total   Spent    Left  Speed\n\r  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0\r  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0\ncurl: (22) The requested URL returned error: 404 NOT FOUND\n"
        },
        {
            "Start": "2020-03-20T15:23:37.812252155-03:00",
            "End": "2020-03-20T15:23:38.098147299-03:00",
            "ExitCode": 1,
            "Output": "  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current\n                                 Dload  Upload   Total   Spent    Left  Speed\n\r  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0\r  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0\ncurl: (22) The requested URL returned error: 404 NOT FOUND\n"
        },
        {
            "Start": "2020-03-20T15:24:08.101721633-03:00",
            "End": "2020-03-20T15:24:08.413392739-03:00",
            "ExitCode": 1,
            "Output": "  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current\n                                 Dload  Upload   Total   Spent    Left  Speed\n\r  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0\r  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0\ncurl: (22) The requested URL returned error: 404 NOT FOUND\n"
        }
    ]
}
```
