docker start 4bb387c97843 e0a0df2c9e3b

http://localhost:5601/app/dev_tools#/console

```
GET _search
{
  "query": {
    "match_all": {}
  }
}

GET /

PUT /my-first-index

PUT /my-first-index/_doc/1
{"Description": "To be or not to be, that is the question."}

GET /my-first-index/_doc/1

DELETE /my-first-index/_doc/1

DELETE /my-first-index

GET /wikimedia/_search
```