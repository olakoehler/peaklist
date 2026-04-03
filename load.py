

import json

import psycopg2 as pg2


import os
from dotenv import load_dotenv



load_dotenv()

cleaned_peaks = []
with open('peaks_els.json', 'r', encoding='utf-8') as f:
    peaks_els = json.load(f)
    for peak in peaks_els:
        tag=peak.get('tags', {})
        cleaned={
            'name': tag.get('name'),
            'name_pl': tag.get('name:pl'),
            'height': tag.get('ele'),
            'peak_type': tag.get('natural'),
            'lat': peak.get('lat'),
            'lon': peak.get('lon')

        }
        cleaned_peaks.append(cleaned)

with pg2.connect(os.getenv('DATABASE_URL')) as conn:
    with conn.cursor() as cur:
        cur.execute('''
            CREATE TABLE IF NOT EXISTS tatra_peaks (
                id SERIAL PRIMARY KEY,
                name TEXT,
                name_pl TEXT,
                height FLOAT,
                peak_type TEXT,
                lat FLOAT,     
                lon FLOAT
            )
        ''')
        conn.commit()

with pg2.connect(os.getenv('DATABASE_URL')) as conn:
    with conn.cursor() as cur:
        for peak in cleaned_peaks:
            cur.execute(
                "INSERT INTO tatra_peaks (name, name_pl, height, peak_type, lat, lon) VALUES (%s, %s, %s, %s, %s, %s)",
                (peak['name'], peak['name_pl'], peak['height'], peak['peak_type'], peak['lat'], peak['lon'])
            )
        conn.commit()

with pg2.connect(os.getenv('DATABASE_URL')) as conn:
    with conn.cursor() as cur:
        cur.execute("SELECT COUNT(*) FROM tatra_peaks")
        print(cur.fetchone())
