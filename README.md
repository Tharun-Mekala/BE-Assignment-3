# BE-Assignment-3
Backend Developer Intern - Task Assignment
#List of API and their Usage
1.http://localhost:8080/adduser
  This API is used for adding user to the database and it required name, role input.
2.http://localhost:8080/Consultantlist
  This API returns the all consultants in the database.
3.http://localhost:8080/ClientList
  This API returns the all Clients in the database.
4.http://localhost:8080/client/bookSession
  This API is used for booking appointment it requires feilds like daate, time, cientId, consultantId. 
5.http://localhost:8080/consultant/getAllSessions/{consultantId}
  This API helps the consultant to see their upcoming sessions.
6.http://localhost:8080/client/getAllSession/{clientId}
  This API helps the clients to check their session history.
7.http://localhost:8080/consultant/uploadDocumentList
  This API is used for select the list of documents that consultant will need for
the session. It requries two parameters one is sesioonId, and other one is documentList.
8.http://localhost:8080/client/getDocumentsList/{sessionId}
  This API is for clients to get the details of documents to be uploaded.
9.http://localhost:8080/client/uploadDocuments/{sessionId}/{clientId}
  This API is for client to upload the documents.
10.http://localhost:8080//consultant/getAllDocument/{sessionId}
  This API is for consultants to see the documents.
11.http://localhost:8080/consultent/submitFeedback
  This API is for consultant to provide feedback based on the session to client.
12.http://localhost:8080/client/getReview/{sessionId}
  This API is used for client to see the feedback of a session .
