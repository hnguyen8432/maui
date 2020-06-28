INSTRUCTIONS:
This environment is setup to build/integrate the Docker and Kubernetes application

PREREQUISITE:
Following softwares are required to present on your Windows desktop
- Git Bash
- Virtual box  (Currently 6.0.10 - Software Center)
- Oracle virtual Box Extension Pack (Currently 6.0.14 - Need IT)
- Vagrant (Currently 2.2.5 - Software center)

ACCESS TO CENTOS7 BUILD/INTEGRATION ENVIRONMENT
1) Make sure no other virtual VM is running to avoid port conflict (mostly port 2222)

2) Using Git Bash, navigate to the the folder SKYFIRE-Utilities/docker-container of SKYFIRE-Utilities project.
   These following commands are commonly used:
   vagrant up       # For the first time, it takes about 10 minutes for vagrant to provision, install software etc...
                    # Username/password available are: vagrant/vagrant, root/vagrant

   vagrant ssh      # Login the VM
   vagrant halt     # Shutdown the VM
   vagrant destroy  # CAUTION: Use it only when you want to remove the VM completely

3) While the Centos7 VM is running, can also login with "ssh vagrant@127.0.0.1 -p 2222"    # the password is vagrant

4) The current directory is mounted on the /vagrant folder in the Centos VM. As a result SKYFIRE-Utilities/docker-container
   source code are accessible in both Windows and Linux.

5) To build the docker image.
   vagrant ssh                           # login the VM
   cd /vagrant
   mvn clean install fabric8:build       # docker image is build to tar file and also psuhed to the local docker image repo

6) To push to the image to the docker repository.
   mvn fabric8:push    # Currently default to docker hub account paradise22.

TEST SAMPLE-APP LOCALLY WITH DOCKER-COMPOSE
With the Centos7 VM running
   cd /vagrant/deploy/local-vm-run
   docker-compose up        # Create/run docker container from built image
   curl 127.0.0.1:9080      # Mapped 9080:8080, Should return "Hello wold"
   docker-compose down      # shutdown docker container

RUN THE DEPLOYMENT IN MINIKUBE
Minikude can run side by side with Vagrant VM with SSH port mapping modification
To avoid port 2222 conflict, change the default ssh port mapping of Minikube VM from 2222 to 22222:
On virtualBox UI right click Minikube >> settings >> Network >> Adapter 2 >> Advanced >> Port Forwarding >> Modify the Host port to 22222

1) Start Minikube VM
2) Scp the content of vagrant/deploy/minikube to the Minikube VM (2 files)
3) Login the Minikube VM using command "ssh kube@127.0.0.1 -p 22222" with password 123kube
4) Start kubernetes "sudo minikube start --vm-driver=none"
4) Navigate to the upload location in step 2)
5) Do
   kubectl create -f pod-deployment-v1.yaml --record
   kubectl create -f nodeport-service.yaml --record

6) Do
   kubectl get service                     # Note the service port number equal to 30333
   kubectl describe pd sample |grep Node   # Note the Node ip address      (<Node Ip> )
   curl <Node ip>:30333           # Hello World return

7) Scale the deployment by
   kubectl scale deployments/sample-app-deployment-v1 --replicas=3
   

Do some change

