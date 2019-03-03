
export REPO=us.gcr.io
export PROJECT=suckit-150602
export IMAGE=flight-log-api

clean:
	mvn clean

build:
	mvn install
	docker build -t $(IMAGE) .
	docker tag $(IMAGE) $(REPO)/$(PROJECT)/$(IMAGE)
	docker tag $(IMAGE) $(REPO)/$(PROJECT)/$(IMAGE):dev

run:
	docker stop $(IMAGE) >/dev/null 2>&1
	docker rm $(IMAGE) >/dev/null 2>&1
	docker run --name $(IMAGE) -d -p 80:8080 --add-host sql.morsecode-inc.com:173.255.113.87 $(IMAGE) 

push:
	docker push $(REPO)/$(PROJECT)/$(IMAGE)
	docker push $(REPO)/$(PROJECT)/$(IMAGE):dev

