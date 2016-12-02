import { combineReducers } from 'redux'

import BreedsReducer from './reducerBreed'
import EspecieReducer from './reducerEspecie'
import AnimalsReducer from './reducerAnimals'
import OrderReducer from './reducerOrder'
import EmployeerReducer from './reducerEmployeer'
import AppointmentReducer from './reducerAppointment'
import ProductReducer from './reducerProduct'
import DashboardReducer from './reducerDashboard'
import CustomerReducer from './reducerCustomer'

import ModalReducer from './reducerModal'

import { reducer as formReducer } from 'redux-form'

const rootReducer = combineReducers({
  breedState: BreedsReducer,
  especieState: EspecieReducer,
  animalsState: AnimalsReducer,
  customerState: CustomerReducer,
  ordersState: OrderReducer,
  employeersState: EmployeerReducer,
  appointmentsState: AppointmentReducer,
  productsState: ProductReducer,
  dashboardsState : DashboardReducer, 
  form: formReducer,
  modal: ModalReducer
})

export default rootReducer
