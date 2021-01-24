var dataVue = {

	getData : function(cityName) {
		this.getAPIData(cityName).then((data)=>{
			var vm = new Vue({
				el: '#items',
				data: {
					items: data
				}
				
			});
			console.log('-------data inside js ----',data);
		})

	},
	getAPIData: function(cityName,callback){
		var url = "/v1/weather/getForcast?cityName="+cityName;
		return fetch(url,{
			method: 'GET',
			headers: {}
		}).then((response)=>{
			return response.json().then((data)=>{
				return data;
			}).catch((err)=>{
				console.log(err);
			})
		});
		
	}
}