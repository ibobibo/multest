docker-compose up -d
echo ${CI_JOB_ID}
docker network connect "selenium-headless-network-${CI_JOB_ID}" selenium_test_runner_${CI_JOB_ID}
docker inspect --format='{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' selenium-hub
