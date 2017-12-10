
curl -X POST -H "Content-Type: application/json" -d \
' 
{
  "messageName": "TASKA",
  "businessKey": "abc"
}
' \
localhost:8080/rest/message
