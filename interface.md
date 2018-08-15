* portfolio interface
	**getUserAllPortfolio
		url:'/portfolio/getAll'
		method:	GET	
		params:
		{
			id:1or2or3..
		}
		response:
		{
			[
			{
				"portfolioId": 4,
				"createDate": "2018-08-15 03:10:47",
				"portfolioName": "test1",
				"symbols": []
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
					"symbols": []
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
	