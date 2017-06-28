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
local storeID -- armazenar id


function scene:create(event)
	
	local grupoCena = self.view 	

	display.setDefault("background", 0.3, 0.6, 1)

	LabelUser = display.newText({text="UserName",x=display.contentWidth/2,y=display.contentHeight/2 - 23})
	LabelUser:setFillColor(0,1,0)
	grupoCena:insert(LabelUser)

	LabelPassword = display.newText({text="Password",x=display.contentWidth/2,y=display.contentHeight/2 + 25})
	LabelPassword:setFillColor(0,1,0)

	grupoCena:insert(LabelPassword)

	Buttonlogin = widget.newButton( 
		{
		label="Login", 
		x = display.contentWidth/2 -50, 
		y = display.contentHeight/2 + 90,
		width = 50,
		height = 40,
		onPress = touchOnButtonLogin, 
		shape = "roundedRect"
		}
	)
	grupoCena:insert(Buttonlogin)

	ButtonSingIn = widget.newButton( 
		{
		label="Cadastre-se",
		x = display.contentWidth/2 + 30,
		y = display.contentHeight/2 + 90,
		width = 100,
		height = 40,
		shape = "roundedRect",
		onPress = registrarUsuario
		}
	)
	grupoCena:insert(ButtonSingIn)
end

function ReceivesUserInformation(codigo,nome,email,senha) -- recebe as informacoes do usuario que veio do web service e faz a validacao para o usuario poder fazer login 

	if TxtUserName.text == nome and TxtPassword.text == senha then
		web:storeInformation(codigo,nome,email,senha)-- armazena as informacoes do usuario em variaves globais para poder recuperar em outras telas
		web:recoverPublicacaoIdWS(codigo)
		composer.gotoScene("Logado")
	end
end

function touchOnButtonLogin(event) -- toque no botao de login/ manda a requisicao para o web service
	
	if event.phase == "began" then
		web:recoverUserWS(TxtUserName.text)
	end
	
end

function  registrarUsuario(event) -- toque no botao sing in 
	-- vai para a pagina de cadastro
	if event.phase == "began" then
		composer.gotoScene("CadastrarUsuario")
	end

end

function scene:show(event) 

	if event.phase == "did" then
		TxtUserName = native.newTextField(display.contentWidth/2, display.contentHeight/2, 150, 25 )
		TxtPassword = native.newTextField(display.contentWidth/2, display.contentHeight/2 + 50, 150, 25 )
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











--[[
local email = "username@domain.com"
 
if ( email:match("[A-Za-z0-9%.%%%+%-]+@[A-Za-z0-9%.%%%+%-]+%.%w%w%w?%w?") ) then
   print( email.." IS formatted properly." )
else
   print( email.." is NOT formatted properly." )
end
]]---
