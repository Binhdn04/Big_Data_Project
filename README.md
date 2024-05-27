# YouTube Data Analysis using MapReduce

## Introduction

This project aims to analyze YouTube data using the MapReduce programming model. The data includes video statistics such as views, ratings and comments. The analysis will provide insights into various trends and patterns in YouTube content.

## Table of Contents

- [Introduction](#introduction)
- [Prerequisites](#prerequisites)
- [Data](#data)
- [Architecture](#architecture)
- [Installation](#installation)
- [Usage](#usage)
- [Examples](#examples)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Prerequisites

Before running this project, ensure you have the following installed:

- Java (JDK 8 or above)
- Apache Hadoop
- A Hadoop cluster or a single-node setup for testing
- Python (optional, for data pre-processing and visualization)

## Data

The dataset used in this project is a collection of YouTube video statistics. It includes the following attributes:

video ID : an 11-digit string, which is unique

uploader : a string of the video uploader's username

age : an integer number of days between the date when the video was uploaded and Feb.15,2007 (YouTube's establishment)

category : a string of the video category chosen by the uploader

length : an integer number of the video length

views : an integer number of the views

rate : a float number of the video rate

ratings : an integer number of the ratings

comments : an integer number of the comments

You can download a sample dataset from [Kaggle](https://www.kaggle.com/datasnaek/youtube-new).

## Architecture

The project is designed using the MapReduce framework. The workflow involves:

1. **Data Preprocessing**: Cleaning and preparing the data for analysis.
2. **Mapper**: Processing each record and extracting relevant information.
3. **Reducer**: Aggregating the results from the mappers to produce the final output.
4. **Post-processing**: Further analysis and visualization of the results.

## Installation

1. **Clone the repository**:
    ```sh
    git clone https://github.com/Binhdn04/Big_Data_Project.git
    ```

2. **Set up Hadoop**:
   Follow the [Hadoop installation guide](https://hadoop.apache.org/docs/stable/hadoop-project-dist/hadoop-common/SingleCluster.html) to set up your Hadoop environment.

3. **Compile the Java code**:


## Usage

1. **Upload the data to HDFS**:
    ```sh
    hdfs dfs -mkdir -p /youtube/input
    hdfs dfs -put path-to-your-dataset/youtube_data.csv /youtube/input/
    ```

2. **Run the MapReduce job**:
    ```sh
    hadoop jar Top10Categories.jar bigdata.Top10_Categories /youtube/input /youtube/output
    ```

3. **Retrieve the results**:
    ```sh
    hdfs dfs -cat /youtube/output/part-r-00000
    ```

## Contributing

Contributions are welcome!.

## Contact

For any questions or feedback, please contact [jacksama2222@gmail.com](mailto:jacksama2222@gmail.com).
