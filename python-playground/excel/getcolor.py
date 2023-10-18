import xlrd
from datetime import datetime

workbook = xlrd.open_workbook('neto.xls', formatting_info=True)
sheet = workbook.sheet_by_index(0)

def getBGColor(row, col):
    global workbook
    global sheet

    xfx = sheet.cell_xf_index(row, col)
    xf = workbook.xf_list[xfx]
    bgx = xf.background.pattern_colour_index
    pattern_colour = workbook.colour_map[bgx]
    #Actually, despite the name, the background colour is not the background colour.
    #background_colour_index = xf.background.background_colour_index
    #background_colour = book.colour_map[background_colour_index]
    return pattern_colour

def get_date(cell):
    global workbook

    datemode = workbook.datemode
    date = datetime(*xlrd.xldate_as_tuple(cell, datemode))
    print("date: ")
    print(date)

def worker():
    global workbook
    global sheet
    
    rows = sheet.nrows
    cols = 2
    print(str(rows)+' '+str(cols))
    
    for row in range(rows):

        for col in range(cols):
            cell = sheet.cell_value(row, col)
            
            color_cell = getBGColor(row, col)

            if (color_cell == None):
                color_cell = 'white'

            print (color_cell)

            if (col == 1):
                print(get_date(cell))
            else:
                print(cell)

worker()