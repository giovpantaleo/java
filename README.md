# java
In the folder src there are two different versions for client and server (v1 and v2).
The version v1 is the same solution presented in the tool that I'm trying to deploy.
The version v2 is a modified version, where I send the payload of the request as an object and not as a String.
The difference is in the client side, while I keep the same implementation (of the initial project) for the server side.
The error returned by the server in both cases is "Exception in thread "main" java.io.StreamCorruptedException: invalid stream header: 504F5354".
This happens when I try to deserialize the data. If I use BufferedReader to read the header fields, it works, but I cannot read the payload.

Just to contextualize the code:
- the client is called observer, it performs measurements in the network, it transforms these measurements in a variable of type string and it send this string to the aggregator.
- the server is called aggregator, it reads this string and initializes an instance of the class measure.
In the code provided I put also the class Measure.

If can be useful there are also these two repository:
1. https://github.com/MECPerf/MECPerf
2. https://github.com/giovpantaleo/MECPerf

The former is the original project, the latter is mine and I made some changes to the code to deploy it in R2Lab.

Testing the two versions on my laptop, I used wireshark to verify if the code is executed well and if the packets is corrupted or not and it seems there aren't errors.
