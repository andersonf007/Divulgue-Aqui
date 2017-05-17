--Code here
--Publicacao.lua

local widget =  require ("widget") -- para os botoes
local composer = require ("composer") -- para as telas
local scene = composer.newScene()

-----------------------conectar ao banco de dados ------------------------
local sqlite3 = require( "sqlite3" )
 
local path = system.pathForFile( "data.db", system.DocumentsDirectory )
local db = sqlite3.open( path )
--------------------------------------------------------------------------

local campoDescricao
local textoDescricao

local campoDia
local textoDia

local campoLocalidade
local textoLocalidade

local botaoPublicar
local texto 
local campoPublicar
local publicacao = 
{
  {
  id,
  descricao,
  dia,
  localidade
  }
}

--function criarTabelaNoBanco(event)
	--local sql = [[CREATE TABLE IF NOT EXISTS publicacao (id INTEGER PRIMARY KEY autoincrement, descricao, data, localidade);]]
	--variavel = db:exec( sql )
	--print("criacao do banco : " .. variavel)
--end

--criarTabelaNoBanco()

--function armazenarDados(descricao, data, localidade)
--	local sql = [[INSERT INTO usuario VALUES (NULL, ']]..descricao..[[',']]..data..[[',']]..localidade..[[');]]
--[[	db:exec( sql )
	print("mendagem do banco : " .. db:errmsg())
end
]]--

 function scene:create(event)

	local grupoCena = self.view 

	 --texto = display.newText({mensagem = "VC chegou aqui!" ,30, 100, 240, 300, native.systemFont, 16})

     --texto:setFillColor( 0, 0.5, 1 )

     --grupoCena:insert(texto)
     

     campoDescricao = display.newText({text = "Descricao", x=display.contentWidth/2, y=display.contentHeight/2 - 70, native.systemFont, 16})
     campoDescricao:setFillColor(0,1,0)
     grupoCena:insert( campoDescricao )

     campoDia = display.newText({text = "Data", x=display.contentWidth/2, y=display.contentHeight/2 - 170, native.systemFont, 16})
     campoDia:setFillColor(0,1,0)
     grupoCena:insert( campoDia )

     campoLocalidade = display.newText({text = "Local", x=display.contentWidth/2,y=display.contentHeight/2 - 120, native.systemFont, 16})
     campoLocalidade:setFillColor(0,1,0)
     grupoCena:insert( campoLocalidade )

     botaoPublicar = widget.newButton( {label = "Publicar", x = display.contentWidth/2 - 50,
                                     y = display.contentHeight/2 + 60, native.systemFont, 20} )
                                     --onPress = registrarPublicacao
     grupoCena:insert( botaoPublicar )
end

--[[
function registrarPublicacao( ... )
	if event.phase == "began" then
		armazenarDados(textoDescricao.text, textoDia.text, textoLocalidade.text)
		textoDescricao.text = ""
		textoDia.text = ""
		textoLocalidade.text = ""
		composer.gotoScene("login")
	end
end
]]--
--local function redirecionaTelaCadastro(event)
--	composer.gotoScene("telaCadastro")
--end



function scene:show( event )
 
   -- local grupoCena = self.view
    local phase = event.phase
 
    if ( phase == "did" ) then
        -- Code here runs when the scene is entirely on screen
       
		
		textoDia = native.newTextField(display.contentWidth/2, display.contentHeight/2 - 150, 200, 25 ) 
	    textoDia.inputType = "number" --ver tipo para data no CoronaSDK
		textoLocalidade = native.newTextField(display.contentWidth/2, display.contentHeight/2 - 100 , 200, 25 ) 
		textoDescricao = native.newTextBox( display.contentWidth/2, display.contentHeight/2 - 10, 200, 100, native.systemFont, 200)
     	textoDescricao.isEditable = true
     	--textoDescricao.isFontSizeScaled = true
     	textoDescricao.size  = 14
		 			
    end

end
 
function scene:hide( event )
 
   -- local sceneGroup = self.view
    local phase = event.phase
 
    if ( phase == "will" ) then
        -- Code here runs when the scene is on screen (but is about to go off screen)
        display.remove(textoDescricao)
	    display.remove(textoDia)
	    display.remove(textoLocalidade)
	    
    end
end
 
 
-- destroy()
function scene:destroy( event )
 
    --local sceneGroup = self.view
    -- Code here runs prior to the removal of scene's view
 
end




scene:addEventListener( "create", scene )
scene:addEventListener( "show", scene )
scene:addEventListener( "hide", scene )
scene:addEventListener( "destroy", scene )

return scene