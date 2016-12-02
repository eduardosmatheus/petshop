import axios from 'axios'

import { TOTAL_PAYMENTS, ERROR, ROOT_URL, errorDispatch } from './'

const DASHBOARD_URL = 'dashboards'

export function fetchTotalPayments() {
  return dispatch => {
    axios.get(`${ROOT_URL}/${DASHBOARD_URL}/totalPayments`).then(response => {
      dispatch({
        type : TOTAL_PAYMENTS,
        payload : response.data
      })
    }).catch(errorDispatch)
  }
}
