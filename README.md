# flight-api

Provide a REST API to provide the necessary motor data to a front-end user interface.

This will serve as the back-end for a series of flight-card entry screens to record the flights during each launch.

Ultimate goal of this project is to be able to produce live reports that display:
 - Top Flyers / Month
 - Total Flights / Month / Year
 - AP Bonfire Leaders

# Flight Data Collected

 - Date of Flight
 - Name of Launch
 - Flyer Name
 - Rocket Name
 - Rocket Color
 - Rocket Motor
 - Clustered or Multi-Stage Flight?
 - Heads Up Flight?
 - Certification Flight? (Level1, Level2, Level3)
 - Contest (Optional)
 - NAR/TRA Member ID (Optional)

# Endpoints

> GET /thrustcurve/api/v1/search/impulse/{impulse}

> GET /thrustcurve/api/v1/list/impulses

> GET /thrustcurve/api/v1/list/diameters

> GET /thrustcurve/api/v1/list/manufacturers

> POST /flight/record/new
POST a new flight record to the system, payload must include:

```
{
  "date": "2018-09-03",
  "launch": "Sept Club Launch",
  "first_name": "Joe",
  "last_name": "Hinton",
  "rocket": "Saturn V",
  "rocket_mfg": "Estes",
  "rocket_motor": "D12-3 Estes"
}
```

# Project Details

## Setup

```
gcloud config set project suckit-150602
```

## Build 

```mvn spring-boot run```

```make build```

## Run Docker Image Locally 

```make run```

## Push Docker Image
This requires that you have access to the Google Project.

```make run```
