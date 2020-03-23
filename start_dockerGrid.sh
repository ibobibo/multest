docker-compose up -d
docker ps
docker network connect "selenium-headless-network" selenium_test_runner
docker inspect --format='{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' selenium-hub
