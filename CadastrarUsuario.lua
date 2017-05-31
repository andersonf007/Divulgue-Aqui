--rest
local widget =  require ("widget")
local composer = require ("composer")
local web = require ("webServiceConnection")
local scene = composer.newScene()

local LabelNome
local LabelEmail
local LabelTelefone
local LabelSenha
local TxtNome
local TxtEmail
local TxtSenha
local ButtonCadastrar 

function scene:create(event)

	local grupoCena = self.view 

	LabelNome = display.newText({text="Nome",x=display.contentWidth/2 + 5,y=display.contentHeight/2 - 170})
	LabelNome:setFillColor(0,1,0)
	grupoCena:insert(LabelNome)
	

	LabelEmail = display.newText({text="Email",x=display.contentWidth/2 + 5,y=display.contentHeight/2 - 120})	
	LabelEmail:setFillColor(0,1,0)
	grupoCena:insert(LabelEmail)

	LabelSenha = display.newText({text="Senha",x=display.contentWidth/2 + 5,y=display.contentHeight/2 - 70})
	LabelSenha:setFillColor(0,1,0)
	grupoCena:insert(LabelSenha)

	ButtonCadastrar =  widget.newButton( {label="cadastrar", x = display.contentWidth/2 -50, y = display.contentHeight/2 + 30 ,onPress = saveUser} )
	grupoCena:insert(ButtonCadastrar)
end

function ValidateSave(response) -- validar salvamento

	if response == 300 then
		print("nao pode")
	elseif response == 200 then
		TxtNome.text = ""
		TxtEmail.text = ""
		TxtSenha.text = ""
		composer.gotoScene("login")
	end
end

function saveUser(event)

	if event.phase == "began" then
		web:RegisterUserWS(TxtNome.text, TxtEmail.text, TxtSenha.text)

	end

end

function scene:show(event)
	if event.phase == "did" then
		TxtNome = native.newTextField(display.contentWidth/2, display.contentHeight/2 - 150, 200, 25 ) 
		TxtEmail = native.newTextField(display.contentWidth/2  , display.contentHeight/2 - 100, 200, 25 ) 
		TxtSenha = native.newTextField(display.contentWidth/2, display.contentHeight/2 - 50, 200, 25 ) 
		
	end
end

function scene:hide(event)
	display.remove(TxtNome)
	display.remove(TxtEmail)
	display.remove(TxtSenha)
end

function scene:destroy(event)
end

scene:addEventListener( "create", scene ) 
scene:addEventListener( "show", scene )  
scene:addEventListener( "hide", scene ) 
scene:addEventListener( "destroy", scene )

return scene


