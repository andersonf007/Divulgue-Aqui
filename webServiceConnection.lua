local widget =  require ("widget")
local composer = require ("composer")
local json = require( "json" )  -- Include the Corona JSON library
local webService = {}

local function handleResponse( event )

    if not event.isError then
        local response = json.decode( event.response )
    --    print( "erro : " .. event.response )
        Receivesuserinformation(response.codigo,response.nome,response.email,response.senha)
    else
        print( "Error" )
    end
    return
end

local function handleResponse2( event )

    if not event.isError then
        local response = json.decode( event.response )
    --    print( "erro : " .. event.response )
    else
        print( "Error" )
    end
    return
end

--//////////////////////////////REGISTRAR USUARIO////////////////////////////////////////////////////
function webService:RegisterUserWS(nome,email,senha) -- registrar usuario
		
		local usuario = { nome = nome, email = email, senha = senha }
			
			local jsonUsuario = json.encode(usuario)
			print("jsonCliente : " .. jsonUsuario)
			local headers = {}
					  
			headers["Content-Type"] = "application/json"

			local params = {}

			params.headers = headers

			params.body = jsonUsuario

		network.request( "http://localhost:8084/web-serviceDivulgueAqui/webresources/webService/usuario/insert", "POST", handleResponse, params )
end

--////////////////////////////////////RECUPERAR USUARIO POR NOME ////////////////////////////////////////////
function webService:recoverUserWS(nome) -- recuperar usuario
	
	local usuario = { nome = nome}
			
	local jsonUsuario = json.encode(usuario)
		print("jsonUsuario : " .. jsonUsuario)
	local headers = {}
					  
	headers["Content-Type"] = "application/json"

	local params = {}

	params.headers = headers

	params.body = jsonUsuario

	network.request( "http://localhost:8084/web-serviceDivulgueAqui/webresources/webService/usuario/recuperarNom?nome="..nome, "GET", handleResponse, params )
end

--/////////////////////////////////////ATUALIZAR USUARIO////////////////////////////////////////////////////
function webService:updateUserWS(codigo,nome,email,senha) -- registrar usuario
		
		local usuario = { codigo = codigo, nome = nome, email = email, senha = senha }
			
			local jsonUsuario = json.encode(usuario)
			print("jsonCliente : " .. jsonUsuario)
			local headers = {}
					  
			headers["Content-Type"] = "application/json"

			local params = {}

			params.headers = headers

			params.body = jsonUsuario

		network.request( "http://localhost:8084/web-serviceDivulgueAqui/webresources/webService/usuario/update", "PUT", handleResponse2, params )
end

--///////////////////////////////////REGISTRAR PUBLICACAO////////////////////////////////////////////////////////////////////////////
function webService:RegisterFeedWS(localidade,descricao,categoria,codigo) -- registrar feed
		
		local feed = { localidade = localidade, descricao = descricao, categoria = categoria, codigo = codigo}
			
			local jsonFeed = json.encode(feed)
			print("jsonFeed : " .. jsonFeed)
			local headers = {}
					  
			headers["Content-Type"] = "application/json"

			local params = {}

			params.headers = headers

			params.body = jsonFeed

		network.request( "http://localhost:8084/web-serviceDivulgueAqui/webresources/webService/feed/insert", "POST", handleResponse2, params )
end

return webService