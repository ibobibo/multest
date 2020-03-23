docker-compose up -d
name=docker inspect --format='{{.Name}}'
docker network connect "selenium-headless-network-${CI_JOB_ID}" $name
docker inspect --format='{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' selenium-hub
