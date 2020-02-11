import requests
import json

if __name__ == '__main__':
    url = 'http://httpbin.org/delete'
    payload ={'nombre':'Eduardo', 'curso':'python', 'nivel':'intermedio'}
    headers = {'Conten-Type':'application/json', 'access-token':'12345'}
    
    response =requests.delete(url, data=json.dumps(payload), headers=headers)
    """
    GET
    POST
    PUT
    DELETE
    """
    print(response.url)

    if response.status_code == 200:
        #print(response.content)
        headers_response = response.headers # Dic
        server = headers_response['Server']
        print(server)