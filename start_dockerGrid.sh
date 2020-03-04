ls
docker-compose up -d
docker inspect --format='{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' selenium-hub