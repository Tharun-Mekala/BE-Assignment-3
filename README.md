# BE-Assignment-3
Backend Developer Intern - Task Assignment<br>
<h3><b>List of API and their Usage</b></h3><br>
1.http://localhost:8080/adduser<br>
  This API is used for adding user to the database and it required name, role input.<br>
  eg:
  {
    "name":"Yasin",
    "role":"Consultant"
  }<br>
  data should be passed in this way.<br>
  Excepted Output: "User added Sucessfully."<br>
2.http://localhost:8080/Consultantlist<br>
  This API returns the all consultants in the database.<br>
3.http://localhost:8080/ClientList<br>
  This API returns the all Clients in the database.<br>
4.http://localhost:8080/client/bookSession<br>
  This API is used for booking appointment it requires feilds like daate, time, cientId, consultantId. <br>
  eg:
  {
    "date":"2023-12-04",
    "time":"15:00:00",
    "clientId":3,
    "consultantId":1
  }<br>
  ClientId and consultantId ,Date and Time should be a valid one otherwise bookSession is failled.<br>
5.http://localhost:8080/consultant/getAllSessions/{consultantId}<br>
  This API helps the consultant to see their upcoming sessions.<br>
6.http://localhost:8080/client/getAllSession/{clientId}<br>
  This API helps the clients to check their session history.<br>
7.http://localhost:8080/consultant/uploadDocumentList<br>
  This API is used for select the list of documents that consultant will need for<br>
the session. It requries two parameters one is sesioonId, and other one is documentList.<br>
8.http://localhost:8080/client/getDocumentsList/{sessionId}<br>
  This API is for clients to get the details of documents to be uploaded.<br>
9.http://localhost:8080/client/uploadDocuments/{sessionId}/{clientId}<br>
  This API is for client to upload the documents.<br>
10.http://localhost:8080//consultant/getAllDocument/{sessionId}<br>
  This API is for consultants to see the documents.<br>
11.http://localhost:8080/consultent/submitFeedback<br>
  This API is for consultant to provide feedback based on the session to client.<br>
  eg:
  {
    "sessionId":1,
    "feedback":"Good session"
  }<br>
  SessionId must be a valid one otherwise review is not submitted.<br>
12.http://localhost:8080/client/getReview/{sessionId}<br>
  This API is used for client to see the feedback of a session .<br>
