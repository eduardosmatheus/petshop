import axios from 'axios'

import { BILLING_TOTALS, ERROR, ROOT_URL, errorDispatch } from './'

const DASHBOARD_URL = 'dashboards'

export function fetchBillingTotals() {
  return dispatch => {
    axios.get(`${ROOT_URL}/${DASHBOARD_URL}/billingTotals`).then(response => {
      dispatch({
        type : BILLING_TOTALS,
        payload : response.data
      })
    }).catch(errorDispatch)
  }
}
