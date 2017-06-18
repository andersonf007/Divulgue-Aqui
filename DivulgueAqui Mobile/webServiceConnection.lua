local widget =  require ("widget")
local composer = require ("composer")
local json = require( "json" )  -- Include the Corona JSON library
local webService = {}

local function retornoDoRestParaReceberInformacoesDoUsuario( event )

    if not event.isError then
        local response = json.decode( event.response )
    --    print( "erro : " .. event.response )
        Receivesuserinformation(response.codigo,response.nome,response.email,response.senha) -- manda as informacoes do usuario para a tela de login
    else
        print( "Error" )
    end
    return
end

local function handleResponse2( event )

    if not event.isError then
        local response = json.decode( event.response )
      --  print(response)
     --  print( "erro : " .. event.response )
    else
        print( "Error" )
    end
    return
end

local function retornoDoRestParaCadastroDoUsuario( event )

    if not event.isError then
        local response = json.decode( event.response )
        ValidateSave(response) -- manda o codigo retornado do rest para fazer a validacao do cadastro
      --  print(response)
       print( "erro : " .. event.response )
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

		network.request( "http://localhost:8084/DivulgueAqui/webresources/webService/usuario/inserir", "POST", retornoDoRestParaCadastroDoUsuario, params )
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

	network.request( "http://localhost:8084/DivulgueAqui/webresources/webService/usuario/recuperar/nome?nome="..nome, "GET", retornoDoRestParaReceberInformacoesDoUsuario, params )
end

--/////////////////////////////////////ATUALIZAR USUARIO////////////////////////////////////////////////////
function webService:updateUserWS(codigo,nome,email,senha) -- atualizar usuario
		
		local usuario = { codigo = codigo, nome = nome, email = email, senha = senha }
			
			local jsonUsuario = json.encode(usuario)
			print("jsonCliente : " .. jsonUsuario)
			local headers = {}
					  
			headers["Content-Type"] = "application/json"

			local params = {}

			params.headers = headers

			params.body = jsonUsuario

		network.request( "http://localhost:8084/DivulgueAqui/webresources/webService/usuario/update", "PUT", handleResponse2, params )
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

		network.request( "http://localhost:8084/DivulgueAqui/webresources/webService/pb/inserir", "POST", handleResponse2, params )
end

return webService