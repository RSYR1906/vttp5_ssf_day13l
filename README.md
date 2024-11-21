

### docker command

1. docker --version <br>

Clear the docker compilation/build cache
2. docker system prune <br>
3. docker build -t <docker login>/<app name>:<version> <br>
eg. docker build -t rsyr1906/vttp5a-ssf-day13l:v1 . <br>

Check docker image created in local docker repo <br>
4. docker image ls <br>

Run the image inside the container <br>
5. docker run -d -p <exposed public port>:<application server port> <username>/<image name> <br> 
eg. docker container -d -p 3000:3000 rsyr1906/vttp5a-ssf-day13lecture <br>

Check docker container running <br>
6. docker container ls

Stop a running container <br>
7. docker stop <container id> <br>

Start a stopped container <br>
8. docker start <container id> <br>

To remove a stopped container <br>
9. docker rm <container id> <br>

### Docker compile and push to railway

1. In railway.app, create a service (linked the project) <br>
2. Create the environment variable, SERVER_PORT=3000 <br>
3. In your project root folder (command prompt), execute railway login --browserless <br>
4. Link the project, execute "railway link" <br>
5. Deploy the project to railway, execute "railway up" <br>