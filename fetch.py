import requests
import json
import time

url="https://overpass-api.de/api/interpreter?data=[out:json];node[%22natural%22=%22peak%22][%22name%22](49.0,19.5,49.4,20.5);out;"

for attempt in range(10):
    response = requests.get(url)    
    if response.status_code == 200:
        break
    print(f"Attempt {attempt + 1} failed with status code {response.status_code}, retrying in 10s...")
    time.sleep(10)
else:   
    print("Failed to fetch data after 10 attempts.")

peaks = response.json()

peaks_els = peaks['elements']

with open('peaks_els.json', 'w', encoding='utf-8') as f:
    json.dump(peaks_els, f)
print(f"Saved {len(peaks_els)} peaks")
