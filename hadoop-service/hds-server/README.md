# Hadoop Service -- Server

start dev server with `mvn exec:java`

## This service exposes following RESTful API

```
   [GET] /jobs             - List submitted jobs
   [GET] /jobs/{id}        - Get the job by provided id
   [GET] /jobs/{id}/status - Get the job status by provided id
  [POST] /jobs/upload      - Submit a job
[DELETE] /jobs/{id}        - Delete submitted job by provided id
```