# SpringBoot sample docker image

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=DevSecOpsSamples_java-gradle&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=DevSecOpsSamples_java-gradle) [![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=DevSecOpsSamples_java-gradle&metric=ncloc)](https://sonarcloud.io/summary/new_code?id=DevSecOpsSamples_java-gradle)

@RequestMapping(value="/", method=RequestMethod.GET)  
@RequestMapping(value="/ping", method=RequestMethod.GET)  

## AWS

```bash
ACCOUNT_ID=$(aws sts get-caller-identity --query Account --output text)
REGION=$(aws configure get default.region)

echo "ACCOUNT_ID: $ACCOUNT_ID"
echo "REGION: $REGION"
sleep 1

docker build -t java-gradle . --platform linux/amd64

aws ecr create-repository --repository-name java-gradle --image-scanning-configuration scanOnPush=true --region $REGION

docker tag java-gradle:latest ${ACCOUNT_ID}.dkr.ecr.${REGION}.amazonaws.com/java-gradle:latest

aws ecr get-login-password --region ${REGION} | docker login --username AWS --password-stdin ${ACCOUNT_ID}.dkr.ecr.${REGION}.amazonaws.com

docker push ${ACCOUNT_ID}.dkr.ecr.${REGION}.amazonaws.com/java-gradle:latest
```

## GCP

```bash
COMPUTE_ZONE="us-central1"
PROJECT_ID="sample-project" # replace with your project
```

```bash
echo "PROJECT_ID: ${PROJECT_ID}"

docker build -t java-gradle . --platform linux/amd64
docker tag java-gradle:latest gcr.io/${PROJECT_ID}/java-gradle:latest

gcloud auth configure-docker
docker push gcr.io/${PROJECT_ID}/java-gradle:latest
```
