local widget =  require ("widget") -- para os botoes
local composer = require ("composer") -- para as telas
local web = require ("webServiceConnection")
local scene = composer.newScene()

local LabelUser
local LabelPassword
local TxtUserName
local TxtPassword
local Buttonlogin
local ButtonSingIn

function scene:create(event)
	
	local grupoCena = self.view 	

	display.setDefault("background", 0.3, 0.6, 1)

	logoTipo = display.newImage( "logotipo.png", display.contentWidth/2, 35)
    grupoCena:insert( logoTipo )

	LabelUser = display.newText({text="usuario",x=display.contentWidth/2,y=display.contentHeight/2 - 95})
	LabelUser:setFillColor(0,0,0)
	LabelUser.size = 20
	grupoCena:insert(LabelUser)

	LabelPassword = display.newText({text="senha",x=display.contentWidth/2,y=display.contentHeight/2 - 39})
	LabelPassword:setFillColor(0,0,0)
	LabelPassword.size = 20
	grupoCena:insert(LabelPassword)

	Buttonlogin = widget.newButton( 
		{
		label="Login", 
		x = display.contentWidth/2 -49, 
		y = display.contentHeight/2 + 25,
		width = 48,
		height = 40,
		onRelease = touchOnButtonLogin, 
		shape = "roundedRect"
		}
	)
	grupoCena:insert(Buttonlogin)

	ButtonSingIn = widget.newButton( 
		{
		label="Cadastre-se",
		x = display.contentWidth/2 + 26,
		y = display.contentHeight/2 + 25,
		width = 96,
		height = 40,
		shape = "roundedRect",
		onRelease = registrarUsuario
		}
	)
	grupoCena:insert(ButtonSingIn)
end

function erroEfetuarLogin(codigo) -- mostra a mensagem de erro ao efetuar login
	if codigo == 305 then
		alert = native.showAlert("erro","usuario ou senha incorretos.", {"ok"} )
	elseif codigo == 309 then
		alert = native.showAlert("erro","O usuario nao existe", {"ok"} )
	else
		alert = native.showAlert("erro","erro inesperado.Se o problema persistir entre em contato conosco em suporte.divulgueaqui@gmail.com", {"ok"} )
	end
end

function ReceivesUserInformation(codigo,nome,email,senha,usuario) -- recebe as informacoes do usuario que veio do web service e faz a validacao para o usuario poder fazer login 

	if TxtUserName.text == usuario then
		web:storeInformation(codigo,nome,email,senha,usuario)-- armazena as informacoes do usuario em variaves globais que esta no webservice para poder recuperar em outras telas
		web:recoverPublicacaoIdWS(codigo)
		composer.gotoScene("Logado")
	end
end

function touchOnButtonLogin(event) -- toque no botao de login/ manda a requisicao para o web service
	
	if event.phase == "ended" then
		web:recoverUserWS(TxtUserName.text,TxtPassword.text)
	end
end

function  registrarUsuario(event) -- toque no botao sing in 
	-- vai para a pagina de cadastro
	if event.phase == "ended" then
		composer.gotoScene("CadastrarUsuario")
	end
end

function scene:show(event) 

	if event.phase == "did" then
		TxtUserName = native.newTextField(display.contentWidth/2, display.contentHeight/2 - 70, 150, 25 )
		TxtPassword = native.newTextField(display.contentWidth/2, display.contentHeight/2 - 15, 150, 25 )
		TxtPassword.isSecure = true
	end
end

function scene:hide(event)
	if event.phase == "will" then
		TxtUserName:removeSelf() 
		TxtPassword:removeSelf()
	end	
end

function scene:destroy(event)
end

scene:addEventListener( "create", scene ) -- adiciona o evento da funcao de criar 
scene:addEventListener( "show", scene ) -- adiciona o evento da funcao de entre 
scene:addEventListener( "hide", scene ) -- adiciona o evento da funcao de sair
scene:addEventListener( "destroy", scene )-- adiciona o evento da funcao de destruir 

return scene