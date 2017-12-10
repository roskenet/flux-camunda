
curl -X POST -H "Content-Type: application/json" -d \
' 
{
  "messageName": "TASKB",
  "businessKey": "abc"
}
' \
localhost:8080/rest/message
