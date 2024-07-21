# Dynaconf Loaders

> _lab created for blog post: https://carlosneto.dev/blog/2024/2024-06-08-logstash-sniffing/_

Lab to exemplify how to use Dynaconf with multiple parameter sources, including custom loaders to retrieve parameters from AWS Parameter Store.

The AWS Parameter Store is simulated by a _Localstack_ container created with docker-compose, and its parameters are created by [_put_parameters_aws.py](./_put_parameters_aws.py). The Dynaconf instance is in [./src/config.py](./src/config.py), which retrieves parameters from [./config/*.yaml](./config/) files and AWS Parameter Store.

---

__Directory Files Overview:__

```bash
├── Makefile                # shortcuts to create virtualenv, install dependencies, and start the application
├── docker-compose.yaml     # recipe to run AWS/Localstack container with AWS Parameter Store service enabled
├── _put_parameters_aws.py  # script to create some example parameters in AWS Parameter Store
├── config                  # special directory dedicated to settings files for Dynaconf
│   ├── .secrets.yaml       # settings file dedicated to sensitive data
│   └── settings.yaml       # settings file dedicated to general application parameters
└── src                     # application source code
    ├── app.py              # application module example that imports Dynaconf instance from config.py
    └── config.py           # module dedicated to Dynaconf instance (with custom loader to access AWS Parameter Store)
```

## Step-by-step

1. Load AWS/Localstack environment variables (used by Dynaconf CLI and [./src/config.py](./src/config.py)):

```bash
export $(cat .env)
```

2. Create a virtual environment and install dependencies:

```bash
make setup
```

3. Create a Localstack container to simulate the AWS Parameter Store service:

```bash
docker-compose up -d
```

4. Activate the virtual environment:

```bash
source ./venv/bin/activate
```

5. Create parameters in AWS Parameter Store:

```bash
python3 _put_parameters_aws.py
```

6. List all parameters retrieved via Dynaconf CLI:

```bash
dynaconf -i src.config.settings list
```

7. Run an example application:

```bash
python3 src/app.py

# or
cd src
python3 app.py
```
