local widget =  require ("widget")
local composer = require ("composer")
local json = require( "json" )  -- Include the Corona JSON library
local webService = {}

function webService:storeInformation(codigo,nomeDoUsuario,email,senha,usuario) -- armazena as informacoes do usuario em variaves globais para poder recuperar em outras telas
	codigoUser = codigo
	nomeFicticio = usuario
	nome = nomeDoUsuario
	emailUser = email
	senhaUser = senha	
end

local function retornoDoRestParaReceberInformacoesDoUsuario( event )

    if not event.isError then
        local response = json.decode( event.response )
       -- print(response)
        if response == 305 then
        	erroEfetuarLogin(response) -- chama o metodo do login para mostrar a mensagem de arro
       	else
        ReceivesUserInformation(response.id,response.nome,response.email,response.senha,response.usuario) -- manda as informacoes do usuario para a tela de login
    	end
    else
        print( "Error" )
    end
    return
end

local function retornoDoRestParaReceberInformacoesDaPublicacao( event )

    if not event.isError then
        tabelaPublicacao = json.decode( event.response )
        recebeTabelaDaPublicacao(tabelaPublicacao)
    else
        print( "Error" )
    end
    return
end

local function retornoRestParaConfirmarAlteracaoDoUsuario( event )

    if not event.isError then
        local response = json.decode( event.response )
        confirmacaoDeAtualizacaoDoUsuario(response)
    else
        print( "Error" )
    end
    return
end

local function retornoRestParaFazerSegundaAlteracaoDoUsuario(event)
	if not event.isError then
		local response = json.decode(event.response)
		
		storeInformation(response.id,response.nome,response.email,response.senha,response.usuario)
	else
		print("erro")
	end
	return
end

local function retornoDoRestParaCadastroDoUsuario( event )

    if not event.isError then
        local response = json.decode( event.response )
        ValidateSave(response) -- manda o codigo retornado do rest para fazer a validacao do cadastro
       -- print(response)
       print( "codigo de retorno para dadastro do usuario: " .. event.response )
    else
        print( "Error" )
    end
    return
end

local function retornoDeConfirmacaoDeInsercaoDaPublicacao( event )
	 if not event.isError then
        local response = json.decode( event.response )
        print(response)
        retornoDoCodigoDeInsercaoDaPublicacao( response )

      else
      	print("erro")
      end
end

--//////////////////////////////REGISTRAR USUARIO////////////////////////////////////////////////////
function webService:RegisterUserWS(nome,email,senha,usuario) -- registrar usuario 
		
		local usuario = { nome = nome, email = email, senha = senha, usuario = usuario }
			
			local jsonUsuario = json.encode(usuario)
			--print("jsonCliente : " .. jsonUsuario)
			local headers = {}
					  
			headers["Content-Type"] = "application/json"

			local params = {}

			params.headers = headers

			params.body = jsonUsuario

		network.request( "http://192.168.1.109:8084/DivulgueAqui/webresources/webService/usuario/inserir", "POST", retornoDoRestParaCadastroDoUsuario, params )
end

--////////////////////////////////////RECUPERAR USUARIO POR NOME ////////////////////////////////////////////
function webService:recoverUserWS(usuario,senha) -- recuperar usuario por nome
	
	local usuario = { usuario = usuario, senha = senha}
			
	local jsonUsuario = json.encode(usuario)
		--print("jsonUsuario : " .. jsonUsuario)
	local headers = {}
					  
	headers["Content-Type"] = "application/json"

	local params = {}

	params.headers = headers

	params.body = jsonUsuario

	network.request( "http://localhost:8084/DivulgueAqui/webresources/webService/usuario/recuperar/nome?nome="..jsonUsuario, "GET", retornoDoRestParaReceberInformacoesDoUsuario, params )
end

--////////////////////////////////////RECUPERAR USUARIO POR ID ////////////////////////////////////////////
function webService:recoverUserIdWS(id) -- recuperar usuario por id
	
	local usuario = { id = id}
			
	local jsonUsuario = json.encode(usuario)
		--print("jsonUsuario : " .. jsonUsuario)
	local headers = {}
					  
	headers["Content-Type"] = "application/json"

	local params = {}

	params.headers = headers

	params.body = jsonUsuario

	network.request( "http://localhost:8084/DivulgueAqui/webresources/webService/usuario/recuperarPorId?id="..id, "GET", retornoRestParaFazerSegundaAlteracaoDoUsuario, params )
end

--/////////////////////////////////////ATUALIZAR USUARIO////////////////////////////////////////////////////
function webService:updateUserWS(codigo,nome,email,senha) -- atualizar usuario
		
		local usuario = { codigo = codigo, nome = nome, email = email, senha = senha }
			
			local jsonUsuario = json.encode(usuario)
			--print("jsonCliente : " .. jsonUsuario)
			local headers = {}
					  
			headers["Content-Type"] = "application/json"

			local params = {}

			params.headers = headers

			params.body = jsonUsuario

		network.request( "http://localhost:8084/DivulgueAqui/webresources/webService/usuario/update", "PUT", retornoRestParaConfirmarAlteracaoDoUsuario, params )
end

--///////////////////////////////////REGISTRAR PUBLICACAO////////////////////////////////////////////////////////////////////////////
function webService:RegisterPublicationWS(localidade,descricao,codigo) -- registrar feed
		
		local feed = { localidade = localidade, descricao = descricao, codigo = codigo}
			
			local jsonFeed = json.encode(feed)
			print("jsonFeed : " .. jsonFeed)
			local headers = {}
					  
			headers["Content-Type"] = "application/json"

			local params = {}

			params.headers = headers

			params.body = jsonFeed

		network.request( "http://localhost:8084/DivulgueAqui/webresources/webService/pb/inserir", "POST", retornoDeConfirmacaoDeInsercaoDaPublicacao, params )
end

function webService:recoverPublicacaoIdWS(id) -- recuperar usuario por id
	
	local usuario = { id = id}
			
	local jsonPublicacao = json.encode(usuario)
		--print("jsonPublicacao : " .. jsonPublicacao)
	local headers = {}
					  
	headers["Content-Type"] = "application/json"

	local params = {}

	params.headers = headers

	params.body = jsonPublicacao

	network.request( "http://localhost:8084/DivulgueAqui/webresources/webService/pb/listaTodasPorIdUsuario?id="..id, "GET", retornoDoRestParaReceberInformacoesDaPublicacao, params )
end

return webService