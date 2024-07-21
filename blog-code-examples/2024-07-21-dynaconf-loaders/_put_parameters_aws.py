import boto3


# Configure the boto3 client to use LocalStack
ssm_client = boto3.client('ssm')

# Define application that will load in AWS Parameter Store
APPLICATION_PARAMETERS = {
    "/my-application/PARAMETER_FROM_AWS_PARAMETER_STORE_1": "foo",
    "/my-application/PARAMETER_FROM_AWS_PARAMETER_STORE_2": "bar"
}


# Function to put a parameter into the Parameter Store
def put_parameter(name, value):
    response = ssm_client.put_parameter(
        Name=name,
        Value=value,
        Type="SecureString",
        Overwrite=True,
    )
    return response


def main():
    # Put secure parameter
    for name, value in APPLICATION_PARAMETERS.items():
        response = put_parameter(name, value)
        print(f"Secure parameter put response: {response}")


if __name__ == "__main__":
    main()
