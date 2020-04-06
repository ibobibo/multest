docker-compose up
ls
for i in 1 2 3 4 5 6 7 8 9 10
do
  sleep 1
  echo .
done
docker ps
docker network connect "selenium-headless-network" selenium_test_runner
docker inspect --format='{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' selenium-hub
