WebsocketChat

A chat application using Websockets.

The server-side is implemented using the Websockets api introduced in Java EE7.

The client-side html uses Javascript's websockets api.

Communcation between the client and server is by sending json strings with two fields: type and data.
- type - either "image" or "text"
- data - if the type is text, then it's just a string of text. If it is image, the data is the base64 value of the image data.
