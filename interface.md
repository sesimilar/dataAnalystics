* portfolio interface
	**getUserAllPortfolio
		url:'/portfolio/getAll'
		method:	GET	
		params:
		{
			id:1
		}
		response:
		{
			[
			{
				"portfolioId": 4,
				"createDate": "2018-08-15 03:10:47",
				"portfolioName": "test1",
				"symbols": [
							"symbolid":1,
							"symbol":"aa"				
				]
			},
			{
				"portfolioId": 5,
				"createDate": "2018-08-15 03:26:41",
				"portfolioName": "test1",
				"symbols": []
			}
			]			
		}
		
	**addPortfolio
		url:'/portfolio/addPortfolio'
		method:POST
		request body:
		{
			"userid":""
			"portfolioname":""
		}
		response:
		*if success
			{
				[
				{
					"portfolioId": 4,
					"createDate": "2018-08-15 03:10:47",
					"portfolioName": "test1",
					"symbols": [
						{
							"symbolid":1,
							"symbol":"aa"
						}
					]
				},
				{
					"portfolioId": 5,
					"createDate": "2018-08-15 03:26:41",
					"portfolioName": "test1",
					"symbols": []
				}
				]	
			}
		* if failed
			{
				"error:" + errorMessage()
			}
			
	**deletePortfolio
		url:'portfolio/deletePortfolio'
		method:POST
		request body:
		{
			"portfolioid":1
			"userid":1
		}
		response:
		`same as interface "addPortfolio"
	
*portfolioSymbols
	**addPortfolioSymbol
		url:'portfolioSymbols/addPortfolioSymbols'
		method:POST
		request body:
		{
			"portfolioid":1
			"symbolid":1
		}
		response:
		*if success
			{	
			 "success"
			}
		*if error
			{
			"error"
			}
	**deletePortfolioSymbol
		url:'portfolioSymbols/deletePortfolioSymbol'
		method:POST
		request body:
		{
			"portfolioid":1
			"symbolid":1
		}
		response:
		*same as interface "addPortfolioSymbol"
