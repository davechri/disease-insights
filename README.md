<h1 align="center" style="border-bottom: none;">Disease Insights frontend/backend</h1>
<h3 align="center">Disease ingihts is a spring boot app that renders a word cloud showing significant age groups, drugs, genes, and symptoms for the selected disease.  It uses Elasticsearch to query a backend COVID-19 corpus.  The frontend is ReactJs, and the backend is spring boot Java.</h3>
<p>
It currently only runs as a development application, and needs some work before it can be deployed to production.

## Setup and configuration

### Build backend
```
~/git/disease_insights/backend$ gradle build
```

### Start backend
```
~/git/disease_insights/backend$ java -jar ./build/libs/diseases-0.0.1-SNAPSHOT.jar
```

### Install frontend packages
```
~/git/disease_insights/frontend$ npm install
```

### Start frontend
```
~/git/disease_insights/frontend$ npm run start
```

If browser does not open automatical, enter localhost:3000.

Your browser should render:

![ ](https://github.com/davechri/disease-insights/blob/master/images/disease-insights.png)

## License

  This code is licensed under the [MIT License](https://opensource.org/licenses/MIT).