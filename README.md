 ## Friday, 2018-09-28, C is for Cookie by Kenny Li  
**Interesting Tech News:** [Spotify looks to crack down on family plan sharing](https://www.engadget.com/2018/09/28/spotify-family-plan-confirm-address/)  
### Do Now  
Jot down what you know about a cookie
* Small file given by a website to your web browser for storage on your local machines.
* Useful for maintaining awareness of identity across multiple page visits on same site
* Transmitted with request

### Demo
How to activate the virtual env while demoing
```
. ~/cna/bin/activate
```
[Bill demoed his homework for us today](https://github.com/bnidevs/jUgGeRnAuT/tree/master/13_formation)

### Notes
```python
print(request.args["username"] #only works if username submitted
```
A fix for this would be to use a logic check to see if username was filled in or initialize a placeholder for username

#### HTTP request methods

Get: (Easier for debugging)
* Passed through query string
* Has size limit
* Less secure since it can be seen in the URL

POST:
* Send in background
* No size limit
* Not secure, just harder to see (not encrypted)

**You can specify request type in HTML (GET is default)**

```HTML
<form action="/path" method="GET">
<form action="/path" method="POST">
```

**You can also specify which request to accept in Python**
```python 
@app.route('/', methods = ["GET"])
```
Only accepts GET
```python 
@app.route('/', methods = ["POST"])
```
Only accepts POST
```python 
@app.route('/', methods = ["GET", "POST"])
```
Accepts both

How does one get cookies?
```
request.cookies.get(KEY)
```
* Accesses cookie data if available
* No error thrown if key missing

```
request.cookies.get("username")
```
is equivalent to
```
request.form['username']
```
but will not throw key error if username is not found.

#### Task
With your table buddy
* Make sure your last work can handle GET and/or POST
* Take your browser's developer console for a spin
