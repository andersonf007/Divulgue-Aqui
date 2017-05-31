local widget =  require ("widget")
local composer = require ("composer")
local scene = composer.newScene()
local login = require ("Login")
local web = require ("webServiceConnection")

local LabelNome
local LabelEmail
local LabelTelefone
local LabelSenha
local TxtNome
local TxtEmail
local TxtTelefone
local TxtSenha
local ButtonSave 

function scene:create(event)

	local grupoCena = self.view 
	
	LabelNome = display.newText({text="Nome :",x=display.contentWidth/2 - 125,y=display.contentHeight/2 - 200})
	grupoCena:insert(LabelNome)
	

	LabelEmail = display.newText({text="Email :",x=display.contentWidth/2 - 125,y=display.contentHeight/2 - 150})	
	grupoCena:insert(LabelEmail)


	LabelSenha = display.newText({text="Senha :",x=display.contentWidth/2 - 115,y=display.contentHeight/2 - 100})	
	grupoCena:insert(LabelSenha)

	ButtonSave =  widget.newButton( {label="save", x = display.contentWidth/2 + 100, y = display.contentHeight/2, onPress = updateUser } )
	grupoCena:insert(ButtonSave)
end

function scene:show(event)

	if event.phase == "did" then
		TxtNome = native.newTextField(display.contentWidth/2 + 5, display.contentHeight/2 - 200, 200, 25 )
		TxtNome.text = nomeUser 
		TxtEmail = native.newTextField(display.contentWidth/2 + 5, display.contentHeight/2 - 150, 200, 25 ) 
		TxtEmail.text = emailUser
		TxtSenha = native.newTextField(display.contentWidth/2 + 15, display.contentHeight/2 - 100, 178, 25 )
		TxtSenha.text = senhaUser 
	end
end

function updateUser(event)

	if event.phase == "began" then
		web:updateUserWS(codigoUser, TxtNome.text, TxtEmail.text, TxtSenha.text)
		composer.gotoScene("Logado")
	end
end
function scene:hide(event)	
	display.remove(TxtNome)
	display.remove(TxtEmail)
	display.remove(TxtEmail)
	display.remove(TxtTelefone)
	display.remove(TxtSenha)
end

function scene:destroy(event)
end

scene:addEventListener( "create", scene ) -- adiciona o evento da funcao de criar 
scene:addEventListener( "show", scene ) -- adiciona o evento da funcao de entre 
scene:addEventListener( "hide", scene ) -- adiciona o evento da funcao de sair
scene:addEventListener( "destroy", scene )-- adiciona o evento da funcao de destruir 

return scene
