# customLogApplication

1. I have add swagger-ui.html (http://localhost:8080/swagger-ui.html#) for the Ui documentation.
2. sample JSON :

[
	{"id":"scsmbstgra", "state":"STARTED", "timeStamp": 1491377495212,"applicationLog" : {"type":"APPLICATION_LOG", "host":"12345"}},
	{"id":"scsmbstgrb",	"state":"STARTED", 	"timeStamp": 1491377495213} ,
	{"id":"scsmbstgrc", "state":"FINISHED", "timeStamp":1491377495218},
	{"id":"scsmbstgra","state":"FINISHED","timeStamp": 1491377495217,"applicationLog" : {"type":"APPLICATION_LOG","host":"12345"}},
	{"id":"scsmbstgrc", "state":"STARTED", "timeStamp": 1491377495210},
	{"id":"scsmbstgrb", "state":"FINISHED","timeStamp": 1491377495216}
]

