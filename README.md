# Tatra Peak Tracker

A data pipeline and backend for tracking mountain ascents in the Tatra range.

## What it does

- Fetches named summit data from the OpenStreetMap Overpass API
- Cleans and stores peak data in a PostgreSQL database (Neon)
- Serves as the data layer for a future ascent tracking web app

## Stack

- **Python** — data fetching and loading
- **PostgreSQL** — peak data storage (hosted on Neon)
- **OpenStreetMap / Overpass API** — source of peak data


## Setup

This project connects to a private PostgreSQL instance. The database credentials are not included in this repository.

If you want to run your own instance:
1. Create a PostgreSQL database (e.g. on [Neon](https://neon.tech))
2. Create a `.env` file with `DATABASE_URL=your_connection_string`
3. Install dependencies: `pip install -r requirements.txt`
4. Run `fetch.py` to pull peak data from OSM
5. Run `load.py` to insert into the database

## Data Source

Peak data from [OpenStreetMap](https://www.openstreetmap.org) via the Overpass API, available under ODbL.
